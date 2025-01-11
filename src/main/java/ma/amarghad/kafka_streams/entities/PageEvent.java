package ma.amarghad.kafka_streams.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString
public class PageEvent {
    private String name;
    private String user;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date date;
    private long duration;
}
