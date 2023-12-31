package zhanuzak.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zhanuzak.entity.Course;
import zhanuzak.dto.response.CourseResponse;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select new zhanuzak.dto.response.CourseResponse(c.id,c.courseName,c.dateOfStart,c.description) from Course c")
    List<CourseResponse> findAllCourses();

    @Query("select new zhanuzak.dto.response.CourseResponse(c.id,c.courseName,c.dateOfStart,c.description) from Course c")
    Page<CourseResponse> findAllCourses(Pageable pageable);

    CourseResponse findCourseById(Long id);

    @Query("select new zhanuzak.dto.response.CourseResponse(c.id,c.courseName,c.dateOfStart,c.description) " +
            "from Course c order by c.dateOfStart desc ")
    List<CourseResponse> dateOfStartCourseNew();

    @Query("select new zhanuzak.dto.response.CourseResponse(c.id,c.courseName,c.dateOfStart,c.description) " +
            "from Course c order by c.dateOfStart asc ")
    List<CourseResponse> dateOfStartCourseOwns();

}
