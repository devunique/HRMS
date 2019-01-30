package com.unique.hrms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unique.hrms.model.Email;

@Repository("emailRepository")
public interface EmailServiceRepository extends JpaRepository<Email,Long>{


}
