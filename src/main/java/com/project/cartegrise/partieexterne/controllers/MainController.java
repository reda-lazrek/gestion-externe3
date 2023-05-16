package com.project.cartegrise.partieexterne.controllers;

import com.project.cartegrise.partieexterne.models.Citoyen;
import com.project.cartegrise.partieexterne.models.Demande;
import com.project.cartegrise.partieexterne.models.Document;
import com.project.cartegrise.partieexterne.services.CitoyenService;
import com.project.cartegrise.partieexterne.services.DemandeService;
import com.project.cartegrise.partieexterne.services.DocumentService;
import com.project.cartegrise.partieexterne.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


@Controller
public class MainController {

	Demande maDemande;

	@Autowired
	private EmailService emailService;
	@Autowired
	private DemandeService demandeService;
	@Autowired
	private CitoyenService citoyenService;

	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/")
	public String afficherPageDacceuil() {
		return "index";
	}
    
	@GetMapping("/effection-demande")
	public String afficherPageEffection(Demande demande) {
		return "effectuer-demande";
	}
	
	@GetMapping("/suivie-demande")
	public String afficherPageSuivie() {
		return "suivre-demande";
	}


	@PostMapping("/effectuer")
	public String effectuerDemande(Demande demande,ModelMap model) throws IOException {

		int min = 100000; // Minimum value of range
		int max = 999999; // Maximum value of range
		int code = (int)Math.floor(Math.random() * (max - min + 1) + min);
		demande.getCitoyen().setCode(String.valueOf(code));
		demandeService.add(demande);
		maDemande = demande;
		model.put("demande",maDemande);

		return "effectuer-demande";
	}

		@PostMapping("/send_files")
	public String sendFiles(@RequestParam("documents") MultipartFile[] documents, ModelMap model) throws IOException {

		ArrayList<Document> documentList = new ArrayList<Document>();
		for (MultipartFile document : documents) {
			String documentName = document.getOriginalFilename();
			String documentContentType = document.getContentType();
			String sourceDocumentContent = new String(document.getBytes(), StandardCharsets.UTF_8);
			Document doc = new Document();
			doc.setDocType(documentContentType);
			doc.setNom(documentName);
			doc.setContent(sourceDocumentContent);
			doc.setDemande(maDemande);
			documentList.add(doc);
		}
			documentService.saveAllDocumentsList(documentList);
			maDemande.setDocuments(documentList);
			emailService.sendEmail(maDemande.getCitoyen().getEmail(),"Code Suivie (carte grise demande)",maDemande.getCitoyen().getCode());
			demandeService.edit(maDemande);
			model.put("demande",maDemande);

			return "email-success-page";
	}

	@GetMapping("/getdemandeinfos")
	public String suivreDemande(@RequestParam("code") String code,ModelMap model){
        Demande demande = null;
        demande = demandeService.getDemandeByCode(code);
		if (demande == null){
			return "code-failure-page";
		}else{
			model.put("demande",demande);
			return "infos-demande";
		}

	}

}
