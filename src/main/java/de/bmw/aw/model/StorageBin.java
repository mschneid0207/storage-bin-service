package de.bmw.aw.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StorageBin {

	@Id
	@GeneratedValue
	private Long id;
	private Integer corridor;
	private Integer rack;
	private Integer level;
	private Integer section;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference
	private Warehouse warehouse;

}