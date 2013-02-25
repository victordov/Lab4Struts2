package md.victordov.lab.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import md.victordov.lab.vo.Universitate;
import md.victordov.lab.vo.Profesor;

/**
 * Curs generated by hbm2java
 */
@Entity
@Table(name = "curs", catalog = "uni2_4t")
public class Curs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(Curs.class);
	public Curs() {
	}



	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Universitate getUniversitate() {
		return this.universitate;
	}

	public void setUniversitate(Universitate universitate) {
		this.universitate = universitate;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		log.debug("Curs: The profesor was set");
		this.profesor = profesor;
	}

	public String getNumeCurs() {
		return this.numeCurs;
	}

	public void setNumeCurs(String numeCurs) {
		this.numeCurs = numeCurs;
	}

	public Set<StudCurs> getStudCurses() {
		return this.studCurses;
	}

	public void setStudCurses(Set<StudCurs> studCurses) {
		this.studCurses = studCurses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "c_id", unique = true, nullable = false)
	private Integer CId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "u_id", nullable = false)
	private Universitate universitate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "p_id", nullable = false)
	private Profesor profesor;

	@Column(name = "nume_curs", nullable = false, length = 30)
	private String numeCurs;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curs")
	private Set<StudCurs> studCurses = new HashSet<StudCurs>(0);

}