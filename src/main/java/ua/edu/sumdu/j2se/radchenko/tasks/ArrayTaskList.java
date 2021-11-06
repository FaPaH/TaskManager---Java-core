package ua.edu.sumdu.j2se.radchenko.tasks;

import java.util.Arrays;

public class ArrayTaskList extends AbstractTaskList{

    private int size = 0;
    private Task[] arrayOfTasks = new Task[10];

    public void add(Task task) throws IllegalArgumentException{
        if (arrayOfTasks[arrayOfTasks.length-1] == null) {
            size++;
                if (task != null) {
                    for (int i = 0; i < size; i++) {
                        if (arrayOfTasks[i] == null) {
                            arrayOfTasks[i] = task;
                            i++;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Task cant be null");
                }
            } else {
                arrayOfTasks = Arrays.copyOf(arrayOfTasks, arrayOfTasks.length + size);
            }
        }

    public boolean remove(Task task){
        if (task != null) {
            for (int i = 0; i < size; i++) {
                if (arrayOfTasks[i].equals(task)) {
                    System.arraycopy(arrayOfTasks, i + 1, arrayOfTasks, i, arrayOfTasks.length - 1 - i);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Task getTask(int index) throws IndexOutOfBoundsException{
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("index cant be more than: " + index);
        }
        return arrayOfTasks[index];
    }

    public ListTypes.types getType() {
        return ListTypes.types.ARRAY;
    }
}
