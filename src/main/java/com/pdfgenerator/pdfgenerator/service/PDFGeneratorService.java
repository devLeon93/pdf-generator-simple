package com.pdfgenerator.pdfgenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author leonid.barsucovschi
 */
@Service
public class PDFGeneratorService {

    public void export(HttpServletResponse response) throws IOException {

        try (Document document = new Document(PageSize.A4)) {

            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontTitle.setSize(18);

            Paragraph paragraph = new Paragraph(" This is the title By Leonid Bars. ",fontTitle);
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);

            Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
            fontParagraph.setSize(12);

            Paragraph paragraph1 = new Paragraph("This is a Paragraph devLeon93 ", fontParagraph);
            paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

            document.add(paragraph);
            document.add(paragraph1);

        }

    }
}
