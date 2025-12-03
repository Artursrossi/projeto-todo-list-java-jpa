package todo_list.task;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
        return taskRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<TaskModel> create(@Valid @RequestBody TaskModel taskModel){
        TaskModel createdTask = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> update(@Valid @RequestBody TaskModel taskModel, @PathVariable UUID id)
    {
        TaskModel formattedTask = taskRepository.findById(id).map(task -> {
                    task.setDescription(taskModel.getDescription());
                    task.setTitle(taskModel.getTitle());

            return task;
                }
        ).orElse(null);

        if (formattedTask == null) {
            return ResponseEntity.notFound().build();
        }

        TaskModel updatedTask = taskRepository.save(formattedTask);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    }
}
