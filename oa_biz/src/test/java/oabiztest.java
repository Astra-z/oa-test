import com.study.oa.biz.ClaimVoucherBiz;
import com.study.oa.biz.DepartmentBiz;
import com.study.oa.biz.EmployeeBiz;
import com.study.oa.dao.ClaimVoucherDao;
import com.study.oa.dao.EmployeeDao;
import com.study.oa.entity.ClaimVoucher;
import com.study.oa.entity.Employee;
import com.study.oa.global.Contant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-biz.xml")

public class oabiztest {
    @Autowired
    EmployeeDao employeeDao;
    @Test
    public void testbiz(){
        System.out.println(employeeDao.selectByDepartmentAndPost("10003", Contant.POST_FM));
    }
}
