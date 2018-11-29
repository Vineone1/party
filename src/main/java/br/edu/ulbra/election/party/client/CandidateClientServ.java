package br.edu.ulbra.election.party.client;

import br.edu.ulbra.election.party.output.v1.CandidateOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CandidateClientServ{
    private final CandidateClient candidateClient;

    @Autowired
    public CandidateClientServ(CandidateClient candidateClient){
        this.candidateClient = candidateClient;
    }

    public CandidateOutput getById(Long Id){
        return this.candidateClient.getById(Id);
    }

    @FeignClient(value="candidate-service", url="${url.candidate-service}")
    private interface CandidateClientServ{

        @GetMapping("/v1/candidate/{candidateId}")
        CandidateOutput getById(@PathVariable(name = "candidateId") Long electionId);

    }


}
