package com.Data.DataShowing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends JpaRepository<Stud,Integer> {

}
