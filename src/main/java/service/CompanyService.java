package service;

import modele.Company;

import java.util.List;

public interface CompanyService {

    boolean deleteCompany(int id);
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    Company getCompany(int id);
    List<Company> getCompanies();
}
