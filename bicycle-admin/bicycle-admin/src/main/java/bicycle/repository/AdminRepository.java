package bicycle.repository;

import org.springframework.data.repository.CrudRepository;

import bicycle.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {}
