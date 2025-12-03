package todo_list.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_tasks")
public class TaskModel {
    
    @Id // JPA annotation
    @GeneratedValue(generator = "UUID") // JPA annotation
    private UUID id;
    
    @NotBlank(message = "Title is required and cannot be empty") // Validation annotation
    @Size(min = 3, message = "Title must be at least 3 characters long") // Validation annotation
    @Size(max = 48, message = "Title cannot exceed 48 characters") // Validation annotation
    @Column(nullable = false, length = 48) // JPA annotation
    private String title;
    
    @Size(min = 4, message = "Description must be at least 4 characters long") // Validation annotation
    @Size(max = 512, message = "Description cannot exceed 512 characters") // Validation annotation
    @Column(length = 512) // JPA annotation
    private String description;
    
    @Enumerated(EnumType.STRING) // JPA annotation
    @Column(nullable = false) // JPA annotation
    private TaskStatus status = TaskStatus.TODO;
    
    @Enumerated(EnumType.STRING) // JPA annotation
    @Column(nullable = false) // JPA annotation
    private TaskPriority priority = TaskPriority.NORMAL;
    
    @Column(name = "start_at") // JPA annotation
    private LocalDateTime startAt;
    
    @Column(name = "end_at") // JPA annotation
    private LocalDateTime endAt;
    
    @CreationTimestamp // JPA annotation
    @Column(name = "created_at") // JPA annotation
    private LocalDateTime createdAt;
    
    @UpdateTimestamp // JPA annotation
    @Column(name = "updated_at") // JPA annotation
    private LocalDateTime updatedAt;
}
