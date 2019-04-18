package com.andremorita.java;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andremorita.java.domain.Categoria;
import com.andremorita.java.domain.Cidade;
import com.andremorita.java.domain.Cliente;
import com.andremorita.java.domain.Endereco;
import com.andremorita.java.domain.Estado;
import com.andremorita.java.domain.Produto;
import com.andremorita.java.domain.enums.TipoCliente;
import com.andremorita.java.repositories.CategoriaRepository;
import com.andremorita.java.repositories.CidadeRepository;
import com.andremorita.java.repositories.ClienteRepository;
import com.andremorita.java.repositories.EnderecoRepository;
import com.andremorita.java.repositories.EstadoRepository;
import com.andremorita.java.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringbootRestIonicApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto pro1 = new Produto(null, "Computador", 2000.00);
		Produto pro2 = new Produto(null, "Impressora", 800.00);
		Produto pro3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1, pro2, pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12121212", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("33333333", "4444444"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "0433333", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "034444", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
	}

}
