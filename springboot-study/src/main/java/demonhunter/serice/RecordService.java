package demonhunter.serice;

import com.sun.prism.impl.Disposer;
import demonhunter.model.Record;
import demonhunter.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordService recordService;

    @GetMapping("/query")
    public Object query(Integer id){//Controller==>Service==>Mapper
       Record.record=recordService.query(id);
        return records;
    }

    @PostMapping("test")
    public Object test(Stu stu){
        List<Record> records=recordService.test(stu)
        return records;
    }
}
