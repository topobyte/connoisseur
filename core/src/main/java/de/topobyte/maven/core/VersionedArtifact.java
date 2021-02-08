// Copyright 2021 Sebastian Kuerten
//
// This file is part of connoisseur.
//
// connoisseur is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// connoisseur is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with connoisseur. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.maven.core;

public class VersionedArtifact extends UnversionedArtifact
{

	protected String version;

	public VersionedArtifact(String groupId, String artifactId, String version)
	{
		super(groupId, artifactId);
		this.version = version;
	}

	public String getVersion()
	{
		return version;
	}

	public UnversionedArtifact unversioned()
	{
		return new UnversionedArtifact(groupId, artifactId);
	}

	@Override
	public String toString()
	{
		return groupId + ":" + artifactId + ":" + version;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode() + version.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (!super.equals(o)) {
			return false;
		}
		if (!(o instanceof VersionedArtifact)) {
			return false;
		}
		VersionedArtifact a = (VersionedArtifact) o;
		return version.equals(a.version);
	}

}
