package service;

import dao.DAOComputer;
import modele.Computer;

import java.util.List;

public class ComputerServiceImpl implements ComputerService{

    DAOComputer daoComputer = new DAOComputer();

    @Override
    public boolean deleteComputers(int id) {
        return daoComputer.delete(id);
    }

    @Override
    public boolean addComputers(Computer computer) {
        return daoComputer.create(computer);
    }

    @Override
    public boolean updateComputers(Computer computer) {
        return daoComputer.update(computer);
    }

    @Override
    public Computer getComputer(int id) {
        return daoComputer.find(id);
    }

    @Override
    public List<Computer> getComputers() {
        return daoComputer.findAll();
    }
}
