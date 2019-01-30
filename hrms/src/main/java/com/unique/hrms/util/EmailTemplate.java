package com.unique.hrms.util;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
public class EmailTemplate {
    
	private String strTemplateId;
	
	private String strTemplate;
	
	private Map<String, String> replacementParams;

	public EmailTemplate(String strTemplateId) {
		this.strTemplateId = strTemplateId;
		try {
			this.strTemplate=loadTemplate(strTemplateId);
		} catch(Exception e) {
			this.strTemplate=Constants.BLANK;
		}
	}

	private String loadTemplate(String strTemplateId) throws Exception {
		ClassLoader classLoader =getClass().getClassLoader();
		File file = new File(classLoader.getResource("email-templates/"+strTemplateId).getFile());
		String content =Constants.BLANK;
		try {
			content=new String(Files.readAllBytes(file.toPath()));
		} catch(IOException e) {
			throw new Exception("Could not read template ID :"+strTemplateId); 
		}
		return content;
	}
	
	public String getTemplate(Map<String, String> replacements) {
		String cTemplate =this.getStrTemplate();
		if(!AppUtil.isObjectEmpty(cTemplate)) {
			for(Map.Entry<String, String> entry:replacements.entrySet()) {
				cTemplate=cTemplate.replace("{{"+entry.getKey()+"}}",entry.getValue());
			}
		}
		return cTemplate;
	}

	public String getStrTemplateId() {
		return strTemplateId;
	}

	public void setStrTemplateId(String strTemplateId) {
		this.strTemplateId = strTemplateId;
	}

	public String getStrTemplate() {
		return strTemplate;
	}

	public void setStrTemplate(String strTemplate) {
		this.strTemplate = strTemplate;
	}

	public Map<String, String> getReplacementParams() {
		return replacementParams;
	}

	public void setReplacementParams(Map<String, String> replacementParams) {
		this.replacementParams = replacementParams;
	}
	
	
}
