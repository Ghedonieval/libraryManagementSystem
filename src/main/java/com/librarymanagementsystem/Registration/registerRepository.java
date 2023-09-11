package com.librarymanagementsystem.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface registerRepository extends JpaRepository<registerRequest, Long> {
    public registerRequest findByUserName(String userName);

    public registerRequest findByPassword(String password);
}
