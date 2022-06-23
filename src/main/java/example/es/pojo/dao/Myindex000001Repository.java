package example.es.pojo.dao;

import example.es.pojo.po.MyIndex000001;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Myindex000001Repository extends ElasticsearchRepository<MyIndex000001, String> {
}
