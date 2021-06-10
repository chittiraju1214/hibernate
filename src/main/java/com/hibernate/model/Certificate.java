package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Certificate", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Certificate implements Serializable {

	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer certificateId;

	@Column(name = "CERTIFICATION_COURSE", unique = true, nullable = false, length = 100)
	private String certificationCourse;

	public Integer getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificationCourse() {
		return certificationCourse;
	}

	public void setCertificationCourse(String certificationCourse) {
		this.certificationCourse = certificationCourse;
	}

}
