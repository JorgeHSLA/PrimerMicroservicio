# Extras importantes
## 🔍 Concepto Central
### ORM (Object-Relational Mapping) es un puente entre dos mundos:

-Mundo Objetos (Java/Kotlin)

-Mundo Relacional (SQL/PostgreSQL/MySQL)


### 🧩 Elementos Clave del Mapeo
![image](https://github.com/user-attachments/assets/5fa36eea-f1be-4d7f-aeb6-b6061d1d5140)


### Ejemplo de definicion de la entidad en java

    @Entity  // Indica que es una tabla en la DB
    @Table(name = "companies")  // Personaliza el nombre de la tabla
    public class Company {
    
        @Id  // Marca como clave primaria
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremental
        private Long id;
        
        @Column(
            name = "company_name",  // Nombre de columna en DB
            length = 100,           // Longitud máxima
            nullable = false,       // No acepta nulos
            unique = true           // Valor único
        )
        private String name;
        
        // Relación 1:N con empleados
        @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,  // Operaciones en cascada
            orphanRemoval = true        // Elimina hijos huérfanos
        )
        private List<Employee> employees = new ArrayList<>();
    }

### ⚡ Operaciones CRUD Automatizadas

    // Creación
    Company c = new Company("Microsoft");
    entityManager.persist(c);  // INSERT INTO companies...
    
    // Lectura
    Company c = entityManager.find(Company.class, 1L);  // SELECT * FROM companies WHERE id=1
    
    // Actualización
    c.setName("Microsoft Corp");
    // UPDATE companies SET company_name='Microsoft Corp' WHERE id=1
    
    // Eliminación
    entityManager.remove(c);  // DELETE FROM companies WHERE id=1

### Como se mapean las relaciones?


![image](https://github.com/user-attachments/assets/44495c27-8b28-429f-8a7e-504a41e44034)

### ⚠️ Errores Comunes (y Soluciones)
#### 1. LazyInitializationException

    // Error: Acceder a relaciones fuera de sesión
    company.getEmployees().size(); // ❌ Fallará si es LAZY
    
    // Solución:
    @Query("SELECT c FROM Company c JOIN FETCH c.employees WHERE c.id = :id")
    Company findByIdWithEmployees(@Param("id") Long id);
    
#### 2. Mapeo Incorrecto de Herencia

    // Estrategia recomendada:
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class User { ... }
    
#### 3. N+1 Queries
  Solución: Usar siempre JOIN FETCH en consultas con relaciones

### 🚀 Buenas Prácticas

    // 1. Usar DTOs para lecturas
    public record CompanyDto(Long id, String name) {}
    
    // 2. FetchType.LAZY en relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    
    // 3. Validar esquemas en producción
    spring.jpa.hibernate.ddl-auto=validate
    
    // 4. Índices para búsquedas frecuentes
    @Table(indexes = @Index(columnList = "company_name"))
