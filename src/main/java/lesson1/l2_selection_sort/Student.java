package lesson1.l2_selection_sort;

/**
 * Created by xuhu on 2017/9/23.
 */
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int score;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int compareTo(Student o) {
        return score != o.score ? score - o.score : id - o.id;
    }


    public static final class StudentBuilder {
        private int id;
        private String name;
        private int score;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withScore(int score) {
            this.score = score;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setScore(score);
            return student;
        }
    }
}
