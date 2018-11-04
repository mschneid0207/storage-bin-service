package de.bmw.aw.storagebinservice.rabbitmq;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageBinRabbitMq implements Serializable {
    private Long id;
    private Integer corridor;
    private Integer rack;
    private Integer level;
    private Integer section;
}
