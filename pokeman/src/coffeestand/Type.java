package coffeestand;

public enum Type {
	Fire {

		@Override
		public boolean hasWeakness(Type t) {
			switch (t) {
			case Water:
				return true;
			case Ground:
				return true;
			default:
				return false;
			}
		}

		@Override
		public boolean hasStrength(Type t) {
			switch (t) {
			case Grass:
				return true;
			case Flying:
				return true;
			default:
				return false;
			}
		}

	},
	Water {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	},
	ELectric {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	},
	Ground {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	},
	Poision {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	},
	Grass {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	},
	Flying {

		@Override
		public boolean hasWeakness(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasStrength(Type t) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	/**
	 * <p>Defines whether the current type is weak to the type specified in variable t</p>
	 * 
	 * <p> Example:
	 * <li>If the current type is Fire and the parameter passed is Water, this method will return true</li></p>
	 * @param t Type to verify weakness on
	 * @return True if current type is weak to type "t", false otherwise
	 */
	public abstract boolean hasWeakness(Type t);

	/**
	 * <p>Defines whether the current type has an advantage over the type specified in variable t</p>
	 * 
	 * <p> Example:
	 * <li>If the current type is Fire and the parameter passed is Grass, this method will return true</li></p>
	 * @param t Type to verify advantage on
	 * @return True if current type is stronger than type "t", false otherwise
	 */
	public abstract boolean hasStrength(Type t);
}
