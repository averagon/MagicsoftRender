package com.siamr.model;

public class ChangePassword {
		private String contraseña;
		private String newContraseña;

		public ChangePassword() {
		} // constructor vacio

		public ChangePassword(String contraseña, String newContraseña) {
			this.contraseña = contraseña;
			this.newContraseña = newContraseña;
		} // constructor

				public String getContraseña() {
					return contraseña;
				}
			
				public void setContraseña(String contraseña) {
					this.contraseña = contraseña;
				}
			
				public String getNewContraseña() {
					return newContraseña;
				}
			
				public void setNewContraseña(String newContraseña) {
					this.newContraseña = newContraseña;
				}

				
		@Override
		public String toString() {
		return "ChangePassword [contraseña=" + contraseña + ", newContraseña=" + newContraseña + "]";
		} // toString
			
		
	} // class ChangePassword


