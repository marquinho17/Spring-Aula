package br.com.aula.aulaspring.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aula.aulaspring.repositorio.Repositorio;
import br.com.aula.aulaspring.modell.Pessoa;

@Controller
public class PessoaController {

  @GetMapping("/maps")
  public String maps(){
    return "maps";
  }

  @GetMapping("/create")
  public String mostrarHtml() {
    return "create";
  }

  @Autowired
  private Repositorio acaoDaRepositorio;

  @GetMapping("/list")
  public ModelAndView listarPessoas() {
    // metodo do spring modelAndView para retornar a visualizaçao que sera exibida
    // nosso caso iremos adicionar a lista pessoas
    ModelAndView mv = new ModelAndView("list");
    Iterable<Pessoa> listaPessoas = acaoDaRepositorio.findAll();
    // adicionando no modelAndView as pessoas que estao na lista pessoas
    mv.addObject("listaPessoas", listaPessoas);
    return mv;
  } 

  

  // Para irmos colocando os objetoss da classe pessoas criada no html
  List<Pessoa> listaPessoas = new ArrayList<>();

  // Metodo post para pegar as informações do html e trazer para o back onde
  // iremos manipular
  

  @PostMapping("/create")
  public String cadastrar(@RequestParam String nome, @RequestParam String telefone) {
    // System.out.println("Meu nome é " + pessoa1.getNome());
    // System.out.println("Esse é meu número " + pessoa1.getTelefone());

    Pessoa pessoa1 = new Pessoa();
    pessoa1.setNome(nome);
    pessoa1.setTelefone(telefone);

    acaoDaRepositorio.save(pessoa1);

    // Ao clicar em salvar vai redirecionar para html list
    return "redirect:/list";
  }

}
