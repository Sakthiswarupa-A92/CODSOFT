
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Course 
{
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int schduled;

    public Course(String code, String title, String description, int capacity) 
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schduled = 0;
    }

    public String getCode() 
    {
        return code;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public int getSchduled() 
    {
        return schduled;
    }

    public boolean hasAvailableSlots() 
    {    
        return schduled < capacity;
    }

    public void schduledStudent() 
    {
        if (hasAvailableSlots()) 
        {
            schduled++;
        }
    }

    public void removeStudent() 
    {
        if (schduled > 0) 
        {
            schduled--;
        }
    }

    @Override
    public String toString() 
    {
        return code + ": " + title + "\nDescription: " + description + "\nCapacity: " + capacity + ", Scheduled: " + schduled;
    }
}

class Student 
{
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) 
    {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public void registerCourse(Course course) 
    {
        if (!registeredCourses.contains(course)) 
        {
            registeredCourses.add(course);
            course.schduledStudent();
            System.out.println(name + " successfully registered for " + course.getTitle());
        } 
        else 
        {
            System.out.println(name + " is already registered for " + course.getTitle());
        }
    }

    public void dropCourse(Course course) 
    {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
            System.out.println(name + " successfully dropped " + course.getTitle());
        } 
        else 
        {
            System.out.println(name + " is not registered for " + course.getTitle());
        }
    }

    public List<Course> getRegisteredCourses() 
    {
        return registeredCourses;
    }

    @Override
    public String toString() 
    {
        return id + ": " + name;
    }
}

class CourseDatabase 
{
    private List<Course> courses;

    public CourseDatabase() 
    {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) 
    {
        courses.add(course);
    }

    public void displayCourses() 
    {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) 
        {
            System.out.println(course);
        }
    }

    public Course getCourseByCode(String code) 
    {
        for (Course course : courses) 
        {
            if (course.getCode().equals(code)) 
            {
                return course;
            }
        }
        return null;
    }
}

class StudentDatabase 
{
    private List<Student> students;

    public StudentDatabase() 
    {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) 
    {
        students.add(student);
    }

    public Student getStudentById(String id) 
    {
        for (Student student : students) 
        {
            if (student.getId().equals(id)) 
            {
                return student;
            }
        }
        return null;
    }
}

public class StudentCourse 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();
        courseDatabase.addCourse(new Course("CS101", "Introduction to Programming", "Learn the basics of programming.", 30));
        courseDatabase.addCourse(new Course("CS102", "Java", "Introduction to java.", 25));
        courseDatabase.addCourse(new Course("CS103", "Python", "Understanding algorithms.", 20));
        courseDatabase.addCourse(new Course("CS103", "Algorithms", "Understanding algorithms.", 10));
        studentDatabase.addStudent(new Student("S1", "Sakthi"));
        studentDatabase.addStudent(new Student("S2", "Swarupa"));
        studentDatabase.addStudent(new Student("S3", "Lakshmi"));
        studentDatabase.addStudent(new Student("S4", "Prasanna"));
        while (true) 
        {
            System.out.println("\n1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:  
                    courseDatabase.displayCourses();
                    break;

                case 2:  
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = studentDatabase.getStudentById(studentId);
                    if (student == null) 
                    {
                        System.out.println("Student1.");
                        break;
                    }
                    courseDatabase.displayCourses();
                    System.out.print("Enter Course Code to register: ");
                    String courseCode = scanner.nextLine();
                    Course course = courseDatabase.getCourseByCode(courseCode);
                    if (course == null) 
                    {
                        System.out.println("JAVA.");
                    } 
                    else if (!course.hasAvailableSlots()) {
                        System.out.println("No available slots in the course.");
                    } 
                    else 
                    {
                        student.registerCourse(course);
                    }
                    break;

                case 3:  // Drop a Course
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.getStudentById(studentId);
                    if (student == null) 
                    {
                        System.out.println("Student2.");
                        break;
                    }
                    System.out.println("Registered Courses:");
                    for (Course registeredCourse : student.getRegisteredCourses()) 
                    {
                        System.out.println(registeredCourse);
                    }
                    System.out.print("Enter Course Code to drop: ");
                    courseCode = scanner.nextLine();
                    course = courseDatabase.getCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("xyz.");
                    } 
                    else 
                    {
                        student.dropCourse(course);
                    }
                    break;

                case 4:  // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
