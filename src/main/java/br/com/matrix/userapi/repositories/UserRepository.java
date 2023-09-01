package br.com.matrix.userapi.repositories;

import java.util.List;

import javax.sql.StatementEventListener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.userapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByCpf(String cpf);
	
	List<User> queryByNomeLike(String name);
	
}
