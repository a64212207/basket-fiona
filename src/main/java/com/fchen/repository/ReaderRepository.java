package com.fchen.repository;

import com.fchen.bean.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Fiona on 2018/6/27.
 */
public interface ReaderRepository extends JpaRepository<Reader,Long> {
    Reader findByUsername(String username);
}
