package Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final HashMap<Integer, Task> taskMap= new HashMap<>();
    private final List<Task> removedTasks= new LinkedList<>();

    public void add(Task task){
        taskMap.put(task.getId(), task);
    }

    public void remove(int id){
        try {
            checkRemove(id);
        }catch (TaskNotFoundException e){
            System.out.println("Задачи с номером"+ id+ " не существует!");
        }
    }

    public void checkRemove(int id) throws TaskNotFoundException{
        if (!taskMap.containsKey(id))
            throw new TaskNotFoundException("Задачи под номером " + id + " не существует");
    }

    public void getAllByDate(LocalDate localDate){
        Map<Integer, Task> list= taskMap.entrySet().stream().filter(x -> x.getValue().appearsln(localDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Task> list1 :
                list.entrySet()) {
            System.out.println("Задача N: " + list1.getKey() + ", " + list1.getValue());
        }
    }
    public void allTaskSortedDate(LocalDate localDate) {
        List<Map.Entry<Integer, Task>> mapSort = new ArrayList<>(taskMap.entrySet());
        mapSort.sort(Comparator.comparingInt(o -> (o.getValue().getDateTime().getDayOfYear())));
        mapSort.forEach(System.out::println);
    }

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }
    public void removedTasks() {
        System.out.println("Удалённые задачи:");
        removedTasks.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Карта задач " + taskMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return Objects.equals(taskMap, that.taskMap) && Objects.equals(removedTasks, that.removedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskMap, removedTasks);
    }
}


