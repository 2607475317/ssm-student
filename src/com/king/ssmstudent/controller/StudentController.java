package com.king.ssmstudent.controller;

import com.king.ssmstudent.pojo.Student;
import com.king.ssmstudent.service.ClassesService;
import com.king.ssmstudent.service.StudentService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/student")
public class StudentController {

    //注入service层
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Student> lists = studentService.queryAll();
        model.addAttribute("students", lists);
        return "student/student_list";
    }

    //删除方法
    @RequestMapping("/delete")
    public String delete(Student stu) {
        //调用service层的删除方法 把数据删除
        studentService.delete(stu);

        return "redirect:/student/index";
    }

    //新增跳转方法
    @RequestMapping("/add")
    public String add(Model model) {
        //查询所有班级将班级放入classes
        model.addAttribute("classes", classesService.queryAll());
        return "student/student_input";
    }

    //增加保存数据方法
    @RequestMapping("/save")
    public String save(Student stu, MultipartFile imgFile, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {
        //完成上传功能
        if (imgFile != null) {

            //获取文件夹路径
            String path = req.getServletContext().getRealPath("/student/uploadFile");
            //文件名称 UUID解决文件名称问题
            String filename = imgFile.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + "." + org.springframework.util.StringUtils.getFilenameExtension(filename);
            //先构造一个文件出来
            File file = new File(path, newFileName);
            //把imgFile写到file里
            IOUtils.copy(imgFile.getInputStream(), new FileOutputStream(file));
            //保存图片
            stu.setImgUrl("/student/uploadFile/"+newFileName);

        }
        if (null!=stu &&stu.getId()!=null && !"".equals(stu.getId())){
            studentService.update(stu);
        }else {
            //把数据保存到数据库
            studentService.save(stu);
        }
            return "redirect:/student/index";
        }

        //修改数据的方法---跳转方法---把修改的数据显示到页面
        @RequestMapping("/edit")
        public String edit(Student stu,Model model){

            //根据stu里面的id 查询数据 放到页面进行回显操作
            Student stu1 = studentService.queryOne(stu);
            model.addAttribute("stu", stu1);
            //查询班级信息传递到前端页面
            model.addAttribute("classes",classesService.queryAll());

            return "student/student_input";

        }
    //登录方法
    @RequestMapping("/login")
    public String login(Student stu,HttpServletRequest req){

        Student currentStu = studentService.login(stu);
        if(currentStu!=null){
            //把信息存入session里面页面
            req.getSession().setAttribute("currentStu", currentStu);
            return "redirect:/student/index";
        }
        //返回登录页面
        return "redirect:/index.jsp";

    }


}

