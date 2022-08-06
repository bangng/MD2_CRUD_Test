package rikkei.academy.model;

public class Student {
    private int id;
    private String name;
    private ClassRoom classRoom;


    public Student() {
    }

    public Student(int id, String name, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return String.format("| ID: %-3d | Name: %-6s | Classroom: %s  |", id, name, classRoom.getName());
    }
}
