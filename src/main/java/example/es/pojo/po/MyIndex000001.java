package example.es.pojo.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "my-index-000001")
public class MyIndex000001 {

    @Id
    @Field(name = "_id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "age", type = FieldType.Integer)
    private Integer age;

    @Field(name = "email", type = FieldType.Text)
    private String email;

    @Field(name = "name", type = FieldType.Text)
    private String name;
}
