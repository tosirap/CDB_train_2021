package service;

import modele.Computer;

import java.util.List;

public interface ComputerService {

    boolean deleteComputers(int id);
    boolean addComputers(Computer computer);
    boolean updateComputers(Computer computer);
    Computer getComputer(int id);
    List<Computer> getComputers();

}
