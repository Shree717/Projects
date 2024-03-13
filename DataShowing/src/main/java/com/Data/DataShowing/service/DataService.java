package com.Data.DataShowing.service;

import com.Data.DataShowing.DataDao;
import com.Data.DataShowing.Stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    DataDao dataDao;
    public List<Stud> getAllData() {
        return dataDao.findAll();
    }
}
