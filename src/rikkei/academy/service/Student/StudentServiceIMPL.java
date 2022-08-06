package rikkei.academy.service.Student;

import rikkei.academy.model.Student;
import rikkei.academy.service.Class_Room.ClassRoomServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    public static List<Student> studentList = new ArrayList<Student>(){
        @Override
        public String toString() {
            String list = "Student List: \n";
            list += "========================== \n";
            for (Student student :
                    this ) {
                list += student.toString() + "\n";
            }
            list += "============================== \n";
            return list;

        }
    };

    static {
        studentList.add(new Student(1,"Hung", ClassRoomServiceIMPL.classRoomList.get(0)));
        studentList.add(new Student(2,"Khanh",ClassRoomServiceIMPL.classRoomList.get(1)));
    }



    @Override
    public List<Student> findall() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);

    }

    @Override
    public void update(Student student) {
        studentList.get(student.getId() - 1).setName(student.getName());
        studentList.get(student.getId() - 1).setClassRoom(student.getClassRoom());

    }

    @Override
    public void deLete(int index) {
        studentList.remove(index);



    }




}
