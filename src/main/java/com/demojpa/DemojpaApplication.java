package com.demojpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demojpa.models.Categoria;
import com.demojpa.repository.ICategoriaRepository;

@SpringBootApplication
public class DemojpaApplication implements CommandLineRunner {
	
	@Autowired
	private ICategoriaRepository repositoryCategoria;

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		testConexion();
		
		//llamar a otros metodos
		//guardar();
		//buscarPorId();
		//modificar();
		//eliminarPorId();
		//cantidadCategorias();
		//eliminarTodos();
		 //encontrarPorIds();
		//buscarTodos();
		//existeId();
		//guardarTodos();
	}
	
	private void guardar() {
		
		Categoria categoria = new Categoria();
		categoria.setNombre("Trips en la playa");
		categoria.setDescripcion("todo tipo de paseos en la  playa");
		repositoryCategoria.save(categoria);
	}
	
	
	private void buscarPorId() {
	    Optional<Categoria> optional = repositoryCategoria.findById(1);
	    if (optional.isPresent())
	        System.out.println(optional.get().getNombre());
	    else
	        System.out.println("Categoria no econtrada");

	}

	private void modificar() {
	    Optional<Categoria> optional = repositoryCategoria.findById(1);
	    if (optional.isPresent()) {
	        Categoria catTemp = new Categoria();
	        catTemp = optional.get();
	        catTemp.setNombre("Caminatas en el Volcan");
	        catTemp.setNombre("Exigentas caminatas para....");
	        repositoryCategoria.save(catTemp);
	        System.out.println(optional.get());
	    } else
	        System.out.println("Categoria no econtrada");

	}
	
	private void eliminarPorId() {
	    repositoryCategoria.deleteById(2);
	}
	
	
	private void cantidadCategorias() {
	    long cantidad = repositoryCategoria.count();
	    System.out.println("Cantidad: " + cantidad);
	}
	
	private void eliminarTodos() {
		
		repositoryCategoria.deleteAll ();
	}

	
	private void encontrarPorIds() {
	    List<Integer> ids = new LinkedList<Integer>();
	    ids.add(1);
	    ids.add(3);
	    ids.add(6);
	    Iterable<Categoria> categoria = repositoryCategoria.findAllById(ids);
	    for (Categoria cat : categoria)
	        System.out.println(cat.getNombre() + " " + cat.getDescripcion());
	}
	
	
	private void buscarTodos() {
	    Iterable<Categoria> categoria = repositoryCategoria.findAll();
	    for (Categoria cat : categoria)
	        System.out.println(cat.getNombre() + " " + cat.getDescripcion());
	}
	
	private void existeId() {
	    boolean existe = repositoryCategoria.existsById(4);
	    System.out.println("La categoria existe: " + existe);
	}
	
	private void guardarTodos() {
	    List<Categoria> lista = getCategoria();
	    repositoryCategoria.saveAll(lista);
	}
	
	
	private List<Categoria> getCategoria() {

	    List<Categoria> lista = new LinkedList<Categoria>();

	    Categoria cat1 = new Categoria();
	    cat1.setNombre("Trips en la playa");
	    cat1.setDescripcion("Paseos en la playa...");

	    Categoria cat2 = new Categoria();
	    cat2.setNombre("Trips en la Ciudad");
	    cat2.setDescripcion("Paseos en la Ciudad...");

	    lista.add(cat1);
	    lista.add(cat2);

	    return lista;
	}
	
	private void testConexion() {
		
		if (repositoryCategoria != null) {
			System.out.println("conexion exitosa: " + "repoCategoria");
		} else
			System.out.println("error a conexion");
		
		
	}

}
