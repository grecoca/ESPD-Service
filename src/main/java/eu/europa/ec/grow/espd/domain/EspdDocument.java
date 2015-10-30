package eu.europa.ec.grow.espd.domain;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Data
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EspdDocument {

	@XmlTransient private String action;// "ca_create_espd" or "eo_import_espd"

	@XmlElement private String name;
	@XmlElement private String natRegNumber;
	@XmlElement private String streetAndNumber;
	@XmlElement private String postcode;
	@XmlElement private String city;
	@XmlElement private String country;
	@XmlElement private String contactPerson;
	@XmlElement private String email;
	@XmlElement private String telephone;
	@XmlElement private String website;

	@XmlElement private String procedureDesc;
	@XmlElement private String lotConcerned;
	@XmlElement private String fileRefByCA;
	@XmlElement private String websiteProcDocs;
	
	//Exclusions
	
	@XmlElement private Criterion criminalConvictions;
	@XmlElement private Criterion corruption;
	@XmlElement private Criterion fraud;
	@XmlElement private Criterion terroristOffences;
	@XmlElement private Criterion moneyLaundering;
	@XmlElement private Criterion childLabour;
	
	@XmlElement private Criterion paymentTaxes;
	@XmlElement private Criterion paymentSocsec;
	
	@XmlElement private Criterion breachingObligations;
	@XmlElement private Criterion bankruptSubject;
	@XmlElement private Criterion guiltyGrave;
	@XmlElement private Criterion agreementsEo;
	@XmlElement private Criterion conflictInterest;
	@XmlElement private Criterion involvementPreparation;
	@XmlElement private Criterion earlyTermination;
	@XmlElement private Criterion guiltyMisinterpretation;

	//trick to use MultipartFile as @RequestParam
	public void setAttachment(MultipartFile attachment) throws IOException, JAXBException {}
	public MultipartFile getAttachment() {return null;}

}