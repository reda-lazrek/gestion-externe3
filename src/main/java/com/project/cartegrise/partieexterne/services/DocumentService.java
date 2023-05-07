package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Document;
import com.project.cartegrise.partieexterne.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements DocumentServiceInterface{

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void saveAllDocumentsList(List<Document> documentList){
        for (Document document : documentList){
            documentRepository.save(document);
        }
    }

    @Override
    public Document add(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document edit(Document document) {
        return null;
    }

    @Override
    public Document delete(Document document) {
        return null;
    }
}
