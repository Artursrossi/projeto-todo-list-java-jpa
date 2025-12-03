package todo_list.task;

import java.util.List;
import java.util.Map;
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
        TaskModel updateModel = taskRepository.findById(id).map(task -> {
                    task.setDescription(taskModel.getDescription());
                    task.setTitle(taskModel.getTitle());
                    task.setStatus(taskModel.getStatus());
                    task.setPriority(taskModel.getPriority());
                    task.setStartAt(taskModel.getStartAt());
                    task.setEndAt(taskModel.getEndAt());

                    return task;
                }
        ).orElse(null);

        if (updateModel == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.save(updateModel));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskModel> updateStatus(@RequestBody Map<String, TaskStatus> body, @PathVariable UUID id) {
        TaskModel updateModel = taskRepository.findById(id).map(task -> {
                    task.setStatus(body.get("status"));

                    return task;
                }
        ).orElse(null);

        if (updateModel == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(taskRepository.save(updateModel));
    }

    @PatchMapping("/{id}/priority")
    public ResponseEntity<TaskModel> updatePriority(@RequestBody Map<String, TaskPriority> body, @PathVariable UUID id){
        TaskModel updateModel = taskRepository.findById(id).map(task -> {
                    task.setPriority(body.get("priority"));
                    return task;
                }
        ).orElse(null);

        if (updateModel == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(taskRepository.save(updateModel));
    }

}
