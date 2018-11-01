package de.bmw.aw.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Warehouse {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String location;

    @OneToMany(mappedBy = "warehouse")
    @JsonBackReference
    Set<StorageBin> storageBins;


}
