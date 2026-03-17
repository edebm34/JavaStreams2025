package fp.dam.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Aparte {

	static List<String> nombres = List.of("Ana", "Carlos", "Alba", "Pedro", "Alberto");
	
	static List<String> empiezanPorA(List<String> nombres) {
		return nombres
				.stream()
				.filter(s -> s.startsWith("A"))
				.collect(Collectors.toList());
	}
	
	static List<String> pasarAMayúsculas(List<String> nombres) {
		return nombres
				.stream()
				.peek(s -> s.toUpperCase())
				.collect(Collectors.toList());
	}
	
	static Integer sumaDePares(List<Integer> numeros) {
		return numeros
				.stream()
				.filter(n -> n%2==0)
				.reduce(0, Integer::sum);
	}
	
	static Map<Integer, List<String>> copiaBarataDelGroupByDeSQL(List<String> palabras) {
		return palabras
				.stream()
				.collect(Collectors.groupingBy(s-> s.length()));
	}
	record Empleado(String nombre, String departamento, double salario) {}

	List<Empleado> empleados = List.of(
	    new Empleado("Ana",     "IT",      45000),
	    new Empleado("Carlos",  "RRHH",    32000),
	    new Empleado("Alba",    "IT",      51000),
	    new Empleado("Pedro",   "RRHH",    29000),
	    new Empleado("Alberto", "IT",      38000),
	    new Empleado("Marta",   "RRHH",    41000)
	);
	
	static List<String> empleadosMillonetis(List<Empleado> empleados) {
		return empleados
				.stream()
				.filter(e -> e.departamento().equals("IT") && e.salario() > 40000)
				.map(empleado -> empleado.nombre())
				.sorted()
				.collect(Collectors.toList());
	}
	
	static Optional<Integer> mayorNúmeroImpar(List<Integer> números) {
		return números
				.stream()
				.filter(n -> n % 2 != 0)
				.max(Integer::compare);
	}
	
	record Producto(String nombre, String categoria, double precio) {}

	List<Producto> productos = List.of(
	    new Producto("Laptop",   "Electrónica", 1200),
	    new Producto("Camiseta", "Ropa",         25),
	    new Producto("Móvil",    "Electrónica",  800),
	    new Producto("Pantalón", "Ropa",          40),
	    new Producto("Tablet",   "Electrónica",  450),
	    new Producto("Zapatos",  "Ropa",          90)
	);
	
	static Map<String, List<String>> porCategoría(List<Producto> productos) {
		return productos
				.stream()
				.collect(Collectors.groupingBy(
						Producto::categoria,
						Collectors.mapping(Producto::nombre, Collectors.toList())));
	}
	
	static Double precioMedio(List<Producto> productos) {
		return productos
				.stream()
				.filter(p -> p.categoria().equals("Electrónica"))
				.collect(Collectors.averagingDouble(Producto::precio));
	}
	
	static String zaWarudo(List<String> nombres) {
		return nombres
				.stream()
				.collect(Collectors.joining(" | ", "Empleados: ", "."));
	}
	
	static Map<Boolean, List<Integer>> watashiNoStandoPowerWaSekaiDa(List<Integer> nums) {
		return nums
				.stream()
				.collect(Collectors.partitioningBy(n -> n%2 == 0));
	}
	
	static Map<String, Double> madeInHeaven(List<Producto> productos) {
		return productos
				.stream()
				.collect(Collectors.groupingBy(Producto::categoria,
						Collectors.summingDouble(Producto::precio)));
	}
	
	static String starPlatinum(List<String> palabras) {
		return palabras
				.stream()
				.map(String::toUpperCase)
				.collect(Collectors.joining(", "));
	}
	
	static Map<String, Double> yareYareDaze(List<Empleado> empleados) {
		return empleados
				.stream()
				.collect(Collectors.groupingBy(
						Empleado::departamento,
						Collectors.averagingDouble(Empleado::salario)
						));
	}
	
	static Map<Boolean, List<String>> goGoZeppeli(List<Empleado> empleados) {
		return empleados
				.stream()
				.collect(Collectors.partitioningBy(e -> e.salario() > 40000,
						Collectors.mapping(Empleado::nombre, Collectors.toList())
						));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
