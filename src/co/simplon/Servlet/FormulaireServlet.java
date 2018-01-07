package co.simplon.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.model.CandidaturesManager;
import co.simplon.model.Client;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireServlet() throws ClassNotFoundException, SQLException {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setAttribute("listeReservation", CandidaturesManager.getInstance().getCandidatures());
		this.getServletContext().getRequestDispatcher("/ListeCandidatures.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations saisies par l'utilisateur
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				String adresse = request.getParameter("adresse");
				String parking = request.getParameter("parking");
				String animal = request.getParameter("animal");
				String fumeur = request.getParameter("fumeur");
				String sejour = request.getParameter("gender");
				//List<Client> candidatures = new ArrayList<Client>();
				
//				System.out.println("Nom : " + request.getParameter("nom"));
//				System.out.println("Prénom : " + request.getParameter("prenom"));
//				System.out.println("Téléphone : " + request.getParameter("telephone"));
//				System.out.println("E-mail : " + request.getParameter("email"));
//				System.out.println("Adresse : " + request.getParameter("adresse") + "\n");
				
				
				// InsertData
			
				Client newClient = new Client();
				newClient.setNom(nom);
				newClient.setPrenom(prenom);
				newClient.setTelephone(telephone);
				newClient.setEmail(email);
				newClient.setAdresse(adresse);
				//newClient.setParking(parking);
				if (parking!= null){
					newClient.setParking(true);
	            }else{
	            	newClient.setParking(false);
	            }
				if (animal!= null){
					newClient.setAnimal("Oui");
	            }else{
	            	newClient.setAnimal("Non");
	            }
				if (fumeur!= null){
					newClient.setFumeur("Oui");
	            }else{
	            	newClient.setFumeur("Non");
	            }
				
				newClient.setSejour(sejour);
				
				CandidaturesManager.getInstance().addClient(newClient);
				
				request.setAttribute("newClientAttribute", newClient);
				getServletContext().getRequestDispatcher("/validationFormulaire.jsp").forward(request, response);

				//candidatures.add(newClient);
			}
		}

