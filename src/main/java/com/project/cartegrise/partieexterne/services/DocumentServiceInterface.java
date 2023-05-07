package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Citoyen;
import com.project.cartegrise.partieexterne.models.Document;

import java.util.List;

public interface DocumentServiceInterface {
    public void saveAllDocumentsList(List<Document> documentList);
    public Document add(Document document);
    public Document edit(Document document);
    public Document delete(Document document);
}
