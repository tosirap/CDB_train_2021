package service;

import dao.DAOCompany;
import modele.Company;

import java.util.List;

public class CompanyServiceImpl implements CompanyService{

    DAOCompany daoCompany = new DAOCompany();

    @Override
    public boolean deleteCompany(int id) {
        return daoCompany.delete(id);
    }

    @Override
    public boolean addCompany(Company company){
        return daoCompany.create(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return daoCompany.update(company);
    }

    @Override
    public Company getCompany(int id){
        return daoCompany.find(id);
    }

    @Override
    public List<Company> getCompanies() {
        return daoCompany.findAll();
    }
}
