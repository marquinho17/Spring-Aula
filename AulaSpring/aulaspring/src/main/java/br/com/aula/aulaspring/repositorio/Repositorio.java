package br.com.aula.aulaspring.repositorio;

import br.com.aula.aulaspring.modell.Pessoa;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

//Importar @Repository do Spring
@Repository
//Mudar de class para interface
//Extender a classe CrudRepository do Spring
//Importar a classe Pessoa
public interface Repositorio extends CrudRepository<Pessoa,Integer>{

    
}
