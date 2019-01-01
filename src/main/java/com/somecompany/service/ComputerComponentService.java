package com.somecompany.service;

import com.somecompany.entity.ComputerComponent;

import java.util.List;

public interface ComputerComponentService {

    List<ComputerComponent> getComponents(String strQuery);

    List<ComputerComponent> getComponents(String strQuery, int page);

    void saveComponent(ComputerComponent component);

    ComputerComponent getComponent(int id);

    void deleteComponent(int id);
}
