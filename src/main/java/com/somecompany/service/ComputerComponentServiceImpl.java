package com.somecompany.service;

import com.somecompany.dao.ComputerComponentDAO;
import com.somecompany.entity.ComputerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComputerComponentServiceImpl implements ComputerComponentService {

    @Autowired
    private ComputerComponentDAO computerComponentDAO;

    @Override
    @Transactional
    public List<ComputerComponent> getComponents(String strQuery) {
        return computerComponentDAO.getComponents(strQuery);
    }

    @Override
    @Transactional
    public List<ComputerComponent> getComponents(String strQuery, int page) {
        return computerComponentDAO.getComponents(strQuery, page);
    }

    @Override
    @Transactional
    public void saveComponent(ComputerComponent component) {
        computerComponentDAO.saveComponent(component);
    }

    @Override
    @Transactional
    public ComputerComponent getComponent(int id) {
        return computerComponentDAO.getComponent(id);
    }

    @Override
    @Transactional
    public void deleteComponent(int id) {
        computerComponentDAO.deleteComponent(id);
    }
}
