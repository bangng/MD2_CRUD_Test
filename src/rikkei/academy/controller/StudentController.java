package rikkei.academy.controller;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.model.Student;
import rikkei.academy.service.Class_Room.ClassRoomServiceIMPL;
import rikkei.academy.service.Student.IStudentService;
import rikkei.academy.service.Student.MyList;
import rikkei.academy.service.Student.StudentServiceIMPL;

import java.util.List;

public class StudentController {
   StudentServiceIMPL studentService = new StudentServiceIMPL();
   public List<Student> getStudentList(){
       return StudentServiceIMPL.studentList;
   }
   public Student getStudent(int id){
       return getStudentList().get(id - 1);
   }
   public void createStudent(String studentName, int classroomId){
       studentService.save( new Student(StudentServiceIMPL.studentList.size() + 1,
               studentName,
               new ClassRoom(classroomId, ClassRoomServiceIMPL.classRoomList.get(classroomId - 1).getName()))
       );


   }
   public void editStudentName(int id, String name){
       studentService.update(
               new Student(
                       id,
                       name,
                       StudentServiceIMPL.studentList.get(id - 1).getClassRoom()
               )
       );
   }
  public void editStudentClass(int id, int classroomId){
       studentService.update(
               new Student(
                       id,
                       StudentServiceIMPL.studentList.get(id - 1).getName(),
                       ClassRoomServiceIMPL.classRoomList.get(classroomId - 1)
               )
       );
  }
  public void deleteStudent(int id){
       studentService.deLete(id - 1);
       updateList(id -1);
  }
   public void updateList(int index){
       for (int i = index; i < StudentServiceIMPL.studentList.size(); i++) {
           StudentServiceIMPL.studentList.get(i).setId(i + 1);

       }
   }

   public List<Student> searchStudentByName(String name){
       List<Student> nameSearch = new MyList<>();
       for (Student student: StudentServiceIMPL.studentList){
           if (student.getName().equalsIgnoreCase(name)){
               nameSearch.add(student);
           }
       }
       return nameSearch;
   }
   public List<Student> searchStudentByClassroom(int classroomId){
       List<Student> classroomsearch = new MyList<>();
       for (Student student : StudentServiceIMPL.studentList){
           if (student.getClassRoom().getId() == classroomId){
               classroomsearch.add(student);
           }
       }
       return classroomsearch;
   }
}
