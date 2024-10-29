package com.lucashcx.app;

import com.lucashcx.app.entities.AddUpdateOrganizationEIB;
import com.lucashcx.app.entities.ChangeJobEIB;
import com.lucashcx.app.entities.ChangePersonalInformationEIB;
import com.lucashcx.app.entities.CreatePositionEIB;
import com.lucashcx.app.entities.PutCandidateEIB;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No EIB name given.");
            return;
        }

        switch (args[0]) {
            case "AddUpdateOrganization":
                (new AddUpdateOrganizationEIB()).run();
                break;
            case "PutCandidate":
                (new PutCandidateEIB()).run();
                break;
            case "ChangePersonalInformation":
                (new ChangePersonalInformationEIB()).run();
                break;
            case "CreatePosition":
                (new CreatePositionEIB()).run();
                break;
            case "ChangeJob":
                (new ChangeJobEIB()).run();
                break;
            default:
                System.out.println("No EIB found for name given.");
        }
    }
}
