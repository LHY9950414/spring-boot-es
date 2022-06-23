package example.es.service.impl;

import example.es.pojo.dao.Myindex000001Repository;
import example.es.pojo.po.MyIndex000001;
import example.es.service.Myindex000001Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Myindex000001ServiceImpl implements Myindex000001Service {

    private final Myindex000001Repository myindex000001Repository;

    @Override
    public List<MyIndex000001> getMyindex000001All() {
        List<MyIndex000001> list = new ArrayList<>();
        Iterable<MyIndex000001> myIndex000001s = myindex000001Repository.findAll();
        myIndex000001s.forEach(myIndex000001 -> list.add(myIndex000001));
        return list;
    }
}
